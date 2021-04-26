package org.zerock.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.ImageProductVO;
import org.zerock.domain.ImagePubVO;

import java.io.File;

@Service
public class FileUploadService {
    static String pubFolder = "/Users/im-yegwang/IdeaProjects/BookShoppingMall/web/resources/img/pub";
    static String productFolder = "/Users/im-yegwang/IdeaProjects/BookShoppingMall/web/resources/img/product";
    static String userFolder = "/Users/im-yegwang/IdeaProjects/BookShoppingMall/web/resources/img/user";

//    static String pubTempFolder = "/Users/im-yegwang/IdeaProjects/BookShoppingMall/target/controller-1.0.0-BUILD-SNAPSHOPT/resources/img/pub";
//    static String productTempFolder = "/Users/im-yegwang/IdeaProjects/BookShoppingMall/target/controller-1.0.0-BUILD-SNAPSHOPT/resources/img/product";
//    static String userTempFolder = "/Users/im-yegwang/IdeaProjects/BookShoppingMall/target/controller-1.0.0-BUILD-SNAPSHOPT/resources/img/user";

    public ImagePubVO pubImageUpload(MultipartFile pub_img, String pub_name){

        ImagePubVO imagePubVO = new ImagePubVO();
        imagePubVO.setName(pub_name);
        imagePubVO.setImageListOid(1);
        imagePubVO.setFileSize((int)pub_img.getSize());
        imagePubVO.setType(FilenameUtils.getExtension(pub_img.getOriginalFilename()));

        File saveFile = new File(pubFolder, imagePubVO.getName()+"_pub_represent."+imagePubVO.getType());
        //File saveTempFile = new File(pubTempFolder, imagePubVO.getName()+"_pubRepresent."+imagePubVO.getType());
        try{
            pub_img.transferTo(saveFile);
            //pub_img.transferTo(saveTempFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        imagePubVO.setPath(saveFile.getPath().substring(saveFile.getPath().indexOf("/resources")));
        return imagePubVO;

    }

    public ImageProductVO productImageUpload(MultipartFile product_img, String product_name, String type){
        ImageProductVO imageProductVO = new ImageProductVO();
        imageProductVO.setName(product_name + "_product_" + type);
        if(type.equals("represent"))
            imageProductVO.setImageListOid(2);
        else if(type.equals("description"))
            imageProductVO.setImageListOid(3);
        else{
            System.out.println("invalid type " + type);
            return null;
        }
        imageProductVO.setFileSize((int)product_img.getSize());
        imageProductVO.setType(FilenameUtils.getExtension(product_img.getOriginalFilename()));

        File saveFile = new File(productFolder, imageProductVO.getName()+"."+imageProductVO.getType());
        try{
            product_img.transferTo(saveFile);
            //product_img.transferTo(saveTempFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        imageProductVO.setPath(saveFile.getPath());

        return imageProductVO;

    }

    public void userImageUpload(){

    }

}
