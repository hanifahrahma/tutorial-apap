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
membuat object dari yang di inject yaitu hotelservice. <br>
referensi: [Medium - Mengenal Spring Dependency](https://medium.com/@satya.syahputra/mengenal-spring-dependency-injection-framework-bahasa-indonesia-3c3b9487a59e)

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
---
## Tutorial 3
##### 1. Pada class KamarDb, terdapat method findAllByHotelId, apakah kegunaan dari method tersebut?
Sebelumnya dapat dilihat dari KamarDB yang extends JpaRepository<KamarModel, Long> sehingga JpaRepository 
membantu dalam menyediakan method-method bawaannya. Selain itu dalam modul JPA terdapat QueryMethods, dimana 
membantu menetapkan query secara manual sebagai String atau bahkan dapat derived hanya dari nama method. 
Walaupun cara ini sangat mudah, namun ada beberapa kasus yang tidak dapat membaca nama methodnya, sehingga dapat 
menggunakan method bawaan saja ataupun menggunakan @Query. Maka pada kasus kali ini findByHotelID dibaca oleh JPA sebagai 
pencarian semua kamar yang memiliki idHotel  yang sesuai.
<br>
referensi : [JPA Repositories documentation](https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html)

##### 2. Pada class HotelController, jelaskan perbedaan method addHotelFormPage dan addHotelSubmit?
Perbedaan paling mendasar adalah addHotelFormPage menggunakan @GetMapping sedangkan addHotelSubmit 
menggunakan @PostMapping. Sebelumnya, dapat diketahui @PostMapping yaitu anotasi yang digunakan untuk HTTP 
POST requests dengan menyederhanakan dari  @RequestMapping(method = RequestMethod.POST). Sehingga dari penjelasan 
ini, dapat disimpulkan addHotelFormPage hanya menampilkan form pembuatan Hotel baru dan inisiasi pembuatan hotel baru, 
hal ini juga dapat dilihat dari htmlnya yaitu "form-add-hotel". Pada html tersebut, dapat dilihat object yang digunakan 
adalah hotel yang sudah dilakukan pendefinisian sebagai hotel baru di HotelController dan method yang digunakan adalah post.
 Setelah user melakukan submit, maka akan memproses post dimana hal ini dilakukan oleh method addHotelSubmit. 
 Pada method ini akan terjadi “post” jika sesuai dengan semua ketentuan dan juga terjadi pemanggilan method di bagian service 
 untuk melakukan penyimpanan dengan bantuan save. Selain itu juga parameter kedua method ini berbeda, pada addHotelSubmit 
 menggunakan @ModelAttribute dimana memiliki pengertian sebuah anotasi yang mengikat hasil return suatu method ke sebuah model dan 
 menampilkannya pada web. Sehingga pada addHotelSubmit menggunakan hasil kembalian dari addHotelFormPage untuk dilakukan post.
 <br>
 Referensi : 
 - [PostMapping documentation](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PostMapping.html)
 - [Spring MVC](https://www.baeldung.com/spring-mvc-and-the-modelattribute-annotation)
 
 ##### 3. Jelaskan kegunaan dari JPA Repository!
 JPA adalah metode melakukan akses database dengan bahasa Java sehingga JPA dapat mempermudah dalam melakukan pengaksesan 
 database. Sedangkan JPA repository adalah java persistance API yang memudahkan membuat CRUD pada String Data. Dengan menggunakan 
 JPA repository kita dalam menggunakan method - method yang disediakan tanpa harus melakukan penulisan method berkali - kali. Hal 
 ini dikarenakan JPA repository mempunyai method bawaan yang dapat digunakan disemua interface. Salah satunya seperti pada nomor 1 
 yaitu QueryMethods, yang dimana dapat membantu menetapkan query secara manual sebagai String atau bahkan dapat derived hanya dari nama method.
<br>
Referensi : [JPA Repository](https://josikie.com/tutorial-mencari-data-pada-entity-sesuai-kategori-dengan-spring-boot-dan-jparepository/)

##### 4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?
Pada bagian Controller di class HotelController dan juga KamarController. Pertama pada class KamarController, digunakan 
untuk menghubungkan pembuatan kamar dengan Hotel. Pada KamarModel hubungan kepemilikan hotel dilihat dari HotelModel bukan 
hanya idHotel, sehingga pada KamarController dibutuhkan pencarian HotelModel berdasarkan idHotel yang tekait. Kemudian pada
 HotelController, terdapat method viewDetailHotel yang merupakan method yang menampilkan deskripsi hotel beserta deskripsi kamar 
 yang terdaftar pada hotel tersebut. Hal ini membutuhkan KamarModel untuk dapat melihat deskripsi kamar disetiap hotel yang dituju.


##### 5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!
- FetchType.Lazy digunakan untuk hubungan ManyToMany dan OneToMany, waktu load lebih sedikit dibandingkan Eager dikarenakan hibernate tidak melakukan load semua collection object di child saat object parent di fetch, jadi hanya dilakukan load saat digunakan method getter.
- FetchType.Eager digunakan untuk hubungan ManyToOne dan OneToOne, terlalu banyak loading data yang tidak penting sehingga memberikan pengaruh pada performa karena hibernate melakukan load semua collection object di child setelah object parent di fetch.
- Dalam Hibernate menyediakan Cascade untuk hubungan OneToMany yang memudahkan operasi data. CascadeType.ALL berarti semua operasi CRUD data berpengaruh ke entitas tersebut. 
<br>
Referensi :
- [Cascade pada Hibernate](https://agung-setiawan.com/contoh-penggunaan-cascade-pada-hibernate/)
- [FetchType](https://www.tutorialspoint.com/difference-between-lazy-and-eager-loading-in-hibernate)