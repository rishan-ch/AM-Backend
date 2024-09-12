package com.asset.service.implementation;

import com.asset.model.Asset;
import com.asset.repository.AssetRepository;
import com.asset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Document;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AssetServiceImplementation implements AssetService {

    @Autowired
    private AssetRepository assetRepo;

    @Override
    public Asset addAsset(MultipartFile file) throws IOException {
        Asset asset = new Asset();
        asset.setName(file.getOriginalFilename());
        asset.setData(file.getBytes());
        return assetRepo.save(asset);
    }

    @Override
    public void deleteAsset(int id) {
        assetRepo.deleteById(id);
    }

    @Override
    public Asset getAssetById(int id) {
        return assetRepo.findById(id).orElse(null);
    }

    @Override
    public List<Asset> getAllAsset() {
        return assetRepo.findAll();
    }
}
