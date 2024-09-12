package com.asset.controller;

import com.asset.model.Asset;
import com.asset.service.implementation.AssetServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/file")
public class AssetController {

    @Autowired
    private AssetServiceImplementation assetService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadAsset(@RequestParam("file")MultipartFile file){
        try{
            assetService.addAsset(file);
            return new ResponseEntity<>("File added successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("File not uploaded",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<Asset>> getAllAssets(){
        return new ResponseEntity<>(assetService.getAllAsset(),HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteAsset(@PathVariable int id){
        assetService.deleteAsset(id);
        return new ResponseEntity<>("Asset deleted successfully",HttpStatus.OK);
    }

    @PostMapping("/getInfo/{id}")
    public ResponseEntity<Asset> getAssetById(@PathVariable int id){
        Asset asset = assetService.getAssetById(id);
        if(asset!=null){
            return new ResponseEntity<>(asset,HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
