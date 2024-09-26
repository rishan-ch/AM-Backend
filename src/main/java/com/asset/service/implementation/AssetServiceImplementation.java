package com.asset.service.implementation;

import com.asset.model.Asset;
import com.asset.model.User;
import com.asset.repository.AssetRepository;
import com.asset.repository.UserRepository;
import com.asset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AssetServiceImplementation implements AssetService {

    @Autowired
    private AssetRepository assetRepo;
    @Autowired
    private UserRepository userRepo;

    @Override
    public void addAsset(MultipartFile file, MultipartFile image, int user_id) throws IOException {
        User user = userRepo.findById(user_id).orElse(null);
        if(user!=null){
            Asset asset = new Asset();
            asset.setName(file.getOriginalFilename());
            asset.setData(file.getBytes());
            asset.setImage(image.getBytes());
            asset.setUser(user);
            assetRepo.save(asset);
        }
    }

    @Override
    public void deleteAsset(int id) {
        assetRepo.deleteById(id);
    }

    @Override
    public void updateAsset(MultipartFile file, MultipartFile image, int user_id) throws IOException {
        User user = userRepo.findById(user_id).orElse(null);
        if(user!=null){
            Asset asset = new Asset();
            asset.setName(file.getOriginalFilename());
            asset.setImage(image.getBytes());
            asset.setData(file.getBytes());
            asset.setUser(user);
            assetRepo.save(asset);
        }
    }

    @Override
    public Asset getAssetById(int id) {
        return assetRepo.findById(id).orElse(null);
    }

    @Override
    public List<Asset> getAllAsset() {
        return assetRepo.findAll();
    }

    @Override
    public List<Asset> getAssetByUserId(int id) {
        return assetRepo.findByUser_id(id);
    }

    @Override
    public List<Asset> getRecent() {
        return assetRepo.findAllByOrderByUploadTimeDesc();
    }
}
