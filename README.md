## Membuat Aplikasi Android Kotlin untuk pemula

Demo :
![nama-video](pemula - Made with Clipchamp.mp4)

Fitur yang ada pada aplikasi:

1. Halaman Splash Screen
  Disini saya menggunakan API terbaru dari splashscreen, yaitu `
    implementation "androidx.core:core-splashscreen:1.0.1` yang saya tambahkan pada dependencies library saya.

2. Halaman Utama.
Syarat:
- Menampilkan gambar dalam format List dengan jumlah minimal 10 item yang berbeda dengan menggunakan RecyclerView untuk menyusun listnya. Informasi yang ditampilkan mengandung :
	Judul dari artikel
	Memaparkan overview dari artikel

- Memunculkan halaman detail ketika salah satu item ditekan. 

3. Halaman Detail.
Syarat:
- Menampilkan gambar dan informasi yang relevan pada halaman detail. 
- Informasi yang relevan mencakup kesamaan informasi yang ditampilkan pada halaman utama dengan halaman detail
- Terdapat judul dan gambar yang sesuai dengan list
- Terdapat kalimat deskripsi yang lebih panjang atau informasi tambahan lainnya
- Gunakan ScrollView supaya konten tetap dapat dilihat ketika aplikasi dirotasi.

4. Halaman About.
Syarat:
Menampilkan tambahan informasi pada halaman about

5. Main menu. Syarat:
- Menampilkan main menu dengan 3 pilihan yaitu List, Grid dan About.
- Apabila List ditekan akan menampilkan recyleview dengan jenis LinearLayout
- Apabila Grid ditekan akan menghasilkan recycleview dengan jenis GridLayout
- Apabila About ditekan akan berpindah ke halaman About
