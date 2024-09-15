package com.pr.imageupload.validation;

import com.pr.imageupload.common.DownloadRequest;
import com.pr.imageupload.model.ImageMetadata;

public class Request {

    public static boolean getImageMetadataByUserValidation(String userID) {
        return stringValidation(userID);
    }

    public static boolean deleteImageMetadataValidation(long id){
        return numberValidation(id);
    }

    public static boolean downloadImageValidation(DownloadRequest downloadRequest){
        // CAN EXTEND TO INCLUDE VALIDATION FOR LOCATION AND DB LEVEL CHECKS
        return stringValidation(downloadRequest.getDownloadLocation()) && numberValidation(downloadRequest.getId());
    }

    public static boolean insertImageMetadataValidation(ImageMetadata imageMetadata){
        return stringValidation(imageMetadata.getUserID()) ||
                stringValidation(imageMetadata.getFileName()) ||
                stringValidation(imageMetadata.getFileType()) ||
                numberValidation(imageMetadata.getFileSize());
    }

    public static boolean updateImageMetadataValidation(ImageMetadata imageMetadata){
        return stringValidationNullable(imageMetadata.getUserID()) ||
                stringValidationNullable(imageMetadata.getFileName()) ||
                stringValidationNullable(imageMetadata.getFileType()) ||
//                file size validation not needed
//                numberValidation(imageMetadata.getFileSize()) ||
                numberValidation(imageMetadata.getId());
    }

    private static boolean stringValidation(String str){
        return str.length()>0;
    }

    private static boolean stringValidationNullable(String str){
        if(str==null){
            return true;
        }
        return str.length()>0;
    }

    private static boolean numberValidation(long id){
        return id>0;
    }


}
