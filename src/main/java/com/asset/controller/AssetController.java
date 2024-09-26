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

    @PostMapping("/upload/{id}")
    public ResponseEntity<String> uploadAsset(@RequestParam("file")MultipartFile file, @RequestParam("image")MultipartFile image, @PathVariable int id){
        try{
            assetService.addAsset(file, image,id);
            return new ResponseEntity<>("File added successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("File not uploaded",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAsset(@RequestParam("file")MultipartFile file,  @RequestParam("image")MultipartFile image,@PathVariable int id){
        try{
            assetService.updateAsset(file,image,id);
            return new ResponseEntity<>("File updated successfully", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("File not updated",HttpStatus.INTERNAL_SERVER_ERROR);
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

    @PostMapping("/getByUser/{id}")
    public ResponseEntity<List<Asset>> getAssetByUser(@PathVariable int id){
        return new ResponseEntity<>(assetService.getAssetByUserId(id),HttpStatus.OK);
    }

    @GetMapping("/getByRecent")
    public ResponseEntity<List<Asset>> getAssetByRecent(){
        return new ResponseEntity<>(assetService.getRecent(),HttpStatus.OK);
    }

}
