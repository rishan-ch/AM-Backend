package com.asset.service;

import com.asset.model.Asset;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface AssetService {
    void addAsset(MultipartFile asset, MultipartFile image, int user_id) throws IOException;
    void deleteAsset(int id);
    void updateAsset(MultipartFile asset, MultipartFile image,  int user_id) throws IOException;
    Asset getAssetById(int id);
    List<Asset> getAllAsset();
    List<Asset> getAssetByUserId(int id);
    List<Asset> getRecent();
}
