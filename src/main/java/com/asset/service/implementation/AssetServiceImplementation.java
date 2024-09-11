package com.asset.service.implementation;

import com.asset.model.Asset;
import com.asset.repository.AssetRepository;
import com.asset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Document;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class AssetServiceImplementation implements AssetService {

    @Autowired
    private AssetRepository assetRepo;

    @Override
    public void addAsset(@RequestParam("file") MultipartFile file) throws IOException {


    }

    @Override
    public void deleteAsset(int id) {

    }

    @Override
    public Asset getAssetById(int id) {
        return null;
    }

    @Override
    public List<Asset> getAllAsset() {
        return null;
    }
}
