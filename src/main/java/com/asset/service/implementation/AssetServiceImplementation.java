//package com.asset.service.implementation;
//
//import com.asset.model.Asset;
//import com.asset.repository.AssetRepository;
//import com.asset.service.AssetService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class AssetServiceImplementation implements AssetService {
//
//    @Autowired
//    private AssetRepository assetRepo;
//
//    @Override
//    public void addAsset(MultipartFile file) throws IOException {
//        String name = file.getOriginalFilename();
//        byte[] data = file.getBytes();
//        LocalDateTime uploadTime = null;
//        Asset asset = new Asset(id,name, data, uploadTime);
//        assetRepo.save(asset);
//    }
//
//    @Override
//    public void deleteAsset(int id) {
//
//    }
//
//    @Override
//    public Asset getAssetById(int id) {
//        return null;
//    }
//
//    @Override
//    public List<Asset> getAllAsset() {
//        return null;
//    }
//}
