package com.asset.service;

import com.asset.model.Asset;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface AssetService {
    void addAsset(MultipartFile asset) throws IOException;
    void deleteAsset(int id);
    Asset getAssetById(int id);
    List<Asset> getAllAsset();
}
