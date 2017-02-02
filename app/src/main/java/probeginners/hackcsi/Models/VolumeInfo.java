package probeginners.hackcsi.Models;

import java.util.ArrayList;

/**
 * Created by rishabhshukla on 02/02/17.
 */

public class VolumeInfo {
    String title;
    ArrayList<String> authors;
    String publisher;
//    String publishedDate;
//    String description;
   int pageCount;
//    ArrayList<String> categories;
//    int averageRating;
//    int ratingsCount;
//    String maturityRating;
    ImageLinks imageLinks;
//    String language;
//    String previewLink;
//    String infoLink;
//    String canonicalVolumeLink;

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

//    public String getPublishedDate() {
//        return publishedDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
    public int getPageCount() {
        return pageCount;
    }
//
//    public ArrayList<String> getCategories() {
//        return categories;
//    }
////
//    public int getAverageRating() {
//        return averageRating;
//    }
//
//    public int getRatingsCount() {
//        return ratingsCount;
//    }
//
//    public String getMaturityRating() {
//        return maturityRating;
//    }
//
    public ImageLinks getImageLinks() {
        return imageLinks;
    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public String getPreviewLink() {
//        return previewLink;
//    }
//
//    public String getInfoLink() {
//        return infoLink;
//    }
//
//    public String getCanonicalVolumeLink() {
//        return canonicalVolumeLink;
//    }
}
