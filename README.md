# Tutorial APAP
## Authors
* **Hanifah Rahmajati** - *1806146972* - *A*
---
## Tutorial 1
### What I have learned today
Pada tutorial kali ini, saya belajar bagaimana cara melakukan git revert dengan benar, selama ini saya 
selalu bermasalah dalam commit-an. Selain itu saya juga belajar menggunakan Spring boot dan merasakan kemudahan
yang ditawarkan oleh spring boot. Saya juga belajar menggunakan issue, selama ini dalam mata kuliah yang menggunakan
github saya tidak pernah menggunakan hal tersebut dan issue ini dapat menggunakan label yang mempermudah kita membedakan.

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker? <br>
Issue tracker adalah fitur yang diberikan oleh github untuk mengumpulkan semua user feedback.
Dengan menggunakan issue, pengguna dapat dapat membantu melakukan tracking dan memperioritaskan 
pekerjaan sesuai dengan kepentingan karena issue memberikan fitur label yang dapat membedakan 
setiap issue yang ada, dan juga memberikan fitur pin issue yang penting. <br>
referensi : [Github - About Issue](https://docs.github.com/en/github/managing-your-work-on-github/about-issues)

2. Apa perbedaan dari git merge dan git merge --squash? <br>
**Git Merge** adalah suatu command dalam git untuk membuat branch yang bercabang menjadi satu kembali 
atau dengan kata lain mengintegrasikan kembali branch tersebut menjadi satu. sedangkan **git merge --squash**
memungkinkan pengguna untuk membuat commit tunggal diatas branch namun tidak benar-benar membuat commit.
Perbedaan yang mendasarnya adalah git merge --squash commit tidak melakukan update pada
HEAD. Jadi git merge menggabungkan file yang ada dibranch yang memiliki commit dengan 
beberapa commit yang berbeda, sedangan squash digabungkan jadi satu kesatuan.
<br>referensi : [Medium - git merge & git merge --squash](https://medium.com/@mitsuyawatanabe/git-merge-and-git-merge-squash-26b3154cccd6)

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi?
- Memudahkan saat bekerja didalam tim, yaitu pembagian pekerjaan yang diberikan untuk tiap-tiap anggota tim dan bagaimana hasil dari pekerjaan
 itu dikumpulkan di tempat yang sama <br>
- Memungkinkan kita mengembalikan source code aplikasi pada keadaan sebelumnya sehingg
dapat berperan sebagai backup<br>
- Membandingkan perubahan source code dari waktu ke waktu <br>
- Dapat melihat siapa yang terakhir mengubah source code yang memungkinkan
terjadinya error <br>
- Dapat dengan mudah melakukan unduh code saat ini ke local dan pekerjaan tim pun terlacak
<br>referensi : [Version Control System](https://agungsulistyan.wordpress.com/2016/06/16/mengenal-version-control-system/)

### Spring
4. Apa itu library & dependency? <br>
Library adalah kumpulan program atau fungsi yang telah ada pada compiler atau intepreter 
untuk memudahkan pemrogram membuat program dan tidak perlu mengakses langsung sistem komputer 
untuk memprogram. Sedangkan dependency adalah ketergantungan suatu komponen dengan komponen
lainnya seperti suatu class dengan suatu interface
<br>referensi : [Library](http://zwhingly.blogspot.com/2016/04/java-serta-library-package-class-object.html)
<br>referensi : [Dependency](http://tutorials.jenkov.com/ood/understanding-dependencies.html#whatis)

5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven? <br>
Maven adalah salah satu build tool yang sering digunakan dalam proyek aplikasi Java dengan
menggunakan konsep Project Object Model (POM). POM tersebut berisi informasi 
dan konfigurasi yang digunakan Maven untuk membuat project. 
Pada dasarnya POM adalah sebuath XML File yang terdapat di dalam project Maven dan di dalam File 
inilah konfigurasi dari project kita berada. Keunggulan dari Maven adalah :
- Membuat struktur project sendiri sehingga project tersebut akan dapat dibuka dengan berbagai IDE
- Memanage Dependency dengan Maven menjadi mudah
- Maven secara dinamis akan mengunduh library dan menyimpanya ke dalam cache local sehingga  bisa digunakan untuk lebih dari satu project.
<br> Ada alternatif lainnya seperti ANT, GNUMake, Gradle, Cmake dll.
<br>referensi : [Petani Kode - Maven](https://www.petanikode.com/java-maven/)
<br>referensi : [Medium - Maven](https://medium.com/@acep.abdurohman90/mengenal-maven-sebagai-java-build-tools-5ba752f75812)

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
- Membuat RESTful services
- Memanipulasi dan menyambungkan dengan Database, modulnya menyediakan SQL, NOSQL
- REST API
- Membangun Enterprise application
selain itu spring dapat digunakan untuk menangani external resources atau sistem
yang bekerja dengan program.
<br>referensi : [What is spring framework used for?](https://www.quora.com/What-is-Spring-Framework-used-for#:~:text=Millions%20of%20developers%20around%20the,and%20speed%20up%20development%20time.)

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
<br>@RequestParam digunakan untuk melakukan request parameter pada URL atau dapat 
disebut query parameter, selain itu biasanya digunakan pada web service tradisional dimana data-data diteruskan dengn query. 
Sedangkan @PathVariable ekstrak dari URI, selain itu juga biasanya digunakan web service RESTful dimana data 
eksplisit pada URL. 
<br>referensi : [Java Code Geeks](https://www.javacodegeeks.com/2017/10/differences-requestparam-pathvariable-annotations-spring-mvc.html)

### What I did not understand
- [] Saya masih kurang mengerti cara menentukan dependencies yang didownload pada tutorial 1
- [x] Saya masih kurang mengerti melakukan ngoding dari awal sekali menggunakan spring boot

---
## Tutorial 2
### Pertanyaan 1 
##### Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut: http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx​ Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi?
Akan terjadi error karena belum ada View Template (HTML & Thymeleaf) yang telah didefinisikan pada Controller di fungsi addHotel. Pada fungsi tersebut, akan me-return view template ‘addHotel.html’ yang dimana belum dilakukan pembuatan.

### Pertanyaan 2
##### Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
Memberikan fleksibilitas untuk memutuskan dimana ingin mengirim objek. Jadi kegunaannya adalah tidak perlu setter method.
Pada kasus ini @Autowired digunakan pada HotelService dimana HotelController tidak akan dapat terbentuk jika tidak ada HotelService.
Hal ini disebut dependency, dimana HotelController bergantung dengan HotelService.
Kesimpulannya adalah pada hotelController tidak perlu ada setter hotelservice karena dengan autowired spring akan otomatis 
membuat object dari yang di inject yaitu hotelservice.

### Pertanyaan 3
##### Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut: http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
 Hal ini dikarenakan pada Controller di method addHotel kita mendefinisikan noTelepon mempunyai required true. Sehingga setiap pembuatan hotel baru diperlukan semua variable terisi jika tidak maka akan terjadi eror.


### Pertanyaan 4
##### Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP, link apa yang harus diakses?
Sebelumnya papa APAP harus membuat hotelnya terlebih dahulu di  http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom. Kemudian masuk ke http://localhost:8080/hotel/viewall atau jika Papa APAP mengetahui idHotelnya dapat mengakses  http://localhost:8080/hotel/view?idHotel=(isi_id) 


### Pertanyaan 5
##### Tambahkan 1 contoh Hotel lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/hotel/viewall ​ , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
Menampilkan semua data hotel yang sudah terbuat. Hal ini dikarenakan setiap hotel yang dibuat akan dimasukkan ke dalam listHotel.
<br>
![alt text](Image/foto-tutorial-2/5.jpg?raw=true)