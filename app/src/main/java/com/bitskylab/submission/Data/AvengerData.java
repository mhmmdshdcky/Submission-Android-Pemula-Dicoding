package com.bitskylab.submission.Data;

import java.util.ArrayList;

public class AvengerData {
    public static String[][] data = new String[][]{
            {"Ironman", "Marvel Avenger", "https://images-na.ssl-images-amazon.com/images/I/515wjJQt2nL._SY445_.jpg", "Iron Man adalah pahlawan super fiksi yang muncul dalam buku komik Amerika yang diterbitkan oleh Marvel Comics, serta media yang terkait. Karakter diciptakan oleh penulis dan editor Stan Lee, yang dikembangkan oleh penulis skenario Larry Lieber, dan dirancang oleh seniman Don Heck dan Jack Kirby"},
            {"Thor", "Marvel Avenger", "https://upload.wikimedia.org/wikipedia/en/thumb/3/3c/Chris_Hemsworth_as_Thor.jpg/220px-Chris_Hemsworth_as_Thor.jpg","Thor adalah sebuah pahlawan super fiksi yang muncul dalam buku-buku komik Amerika yang diterbitkan oleh Marvel Comics. Karakter tersebut, yang berdasarkan pada dewa mitologi Norse dengan nama yang sama, adalah dewa petir dan memegang sebuah palu, yang memberikannya kemampuan terbang dan mengendalikan cuaca."},
            {"Spiderman", "Marvel Avenger", "https://timedotcom.files.wordpress.com/2016/07/spiderman-homecoming.jpg","Spider-Man, adalah pahlawan super fiktif dari Marvel Comics yang diciptakan oleh penulis Stan Lee dan artis Steve Ditko. Ia pertama muncul dalam Amazing Fantasy #15. Ia telah menjadi salah satu pahlawan super yang paling terkenal di dunia."},
            {"Hulk", "Marvel Avenger", "https://www.hindustantimes.com/rf/image_size_960x540/HT/p2/2018/06/15/Pictures/_1caf1900-7098-11e8-bbf6-b72314b60444.jpg","Hulk, adalah tokoh pahlawan super fiksi yang ada pada Marvel Comics. DIciptakan oleh Stan Lee dan Jack Kirby, tokoh ini pertama kali muncul di The Incredible Hulk #1."},
            {"Doctor Strange", "Marvel Avenger", "https://i.pinimg.com/originals/0f/68/69/0f686909539f63ba1d35c49f9ab403b5.png","Doctor Strange adalah sebuah film pahlawan super Amerika yang menampilkan karakter Marvel Comics dengan nama yang sama, diproduksi oleh Marvel Studios dan didistribusikan oleh Walt Disney Motion Pictures. Film ini merupakan film ke-14 dari Marvel Cinematic Universe (MCU)."},
            {"Black Panther", "Marvel Avenger", "https://im.rediff.com/movies/2018/feb/16black-panther2.jpg","Black Panther (T'Challa) adalah seorang pahlawan super fiksi yang muncul di buku komik Amerika yang diterbitkan oleh Marvel Comics. Dibuat oleh editor penulis Stan Lee dan penciller dan co-plotter Jack Kirby, ia pertama kali muncul di Fantastic Four #52 (Juli 1966). Dia adalah pahlawan super hitam pertama dii komik Amerika arus utama, yang memulai debutnya bertahun-tahun sebelum pahlawan super Afrika-Amerika awal seperti Marvel Comics Falcon (1969) dan Luke Cage (1972), dan DC Comics Green Lantern John Stewart (1971) dan Black Lightning (1977). Tokoh tersebut biasanya digambarkan sebagai raja dan pelindung Wakanda, sebuah negara fiksi Afrika."},
            {"Black Widow", "Marvel Avenger", "https://ksassets.timeincuk.net/wp/uploads/sites/55/2018/02/Black-Widow-Avengers-920x584.jpg","Natasha Romanoff atau yang biasa disebut Black Widows adalah salah satu tokoh dalam komik Marvel. Tokoh ini diciptakan oleh Stan Lee, Don Rico, dan Don Heck. Muncul pertama kali di komik berjudul Mystic Comics #4 pada bulan Agustus 1940. Sosok Black Widow merupakan protagonis pada komik tersebut."}
    };

    public static ArrayList<Avenger> getListData(){
        Avenger avenger = null;
        ArrayList<Avenger> list = new ArrayList<>();
        for (String[] aData : data) {
            avenger = new Avenger();
            avenger.setName(aData[0]);
            avenger.setRemarks(aData[1]);
            avenger.setPhoto(aData[2]);
            avenger.setDescription(aData[3]);

            list.add(avenger);
        }

        return list;
    }
}
