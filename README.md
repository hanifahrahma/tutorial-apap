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
---

## Tutorial 4
##### 1. Jelaskan perbedaan th:include dan th:replace!
Sebelumnya dapat diketahui host tag adalah tag yang berisi th:replace, th:include maupun th:insert. Sedangkan fragment tag adalah tag yang berisi th:fragment.
Berikut penjelasan dari th:replace dan th:include :
- th:replace akan menghapus dan menggantikan host tag dengan konten fragment yang spesifik termasuk fragment tagnya
- th:include akan memasukkan spesifik fragment sebagai body dari host tag nya namun tidak termasuk fragment tag nya
	

Referensi :
- [difference-between-thymeleaf-attribute](https://anshulgnit.blogspot.com/2018/05/difference-between-thymeleaf-attribute-replace-insert-and-include.html)
- [thymeleaf-fragments](https://attacomsian.com/blog/thymeleaf-fragments)

##### 2. Jelaskan apa fungsi dari th:object!
th:object digunakan untuk menspesifikan object yang dibuat saat submit form. 
Value dari th:object haru (${..}) spesifik hanya nama dari model attribute yang dimaksud adalah
hanya bisa ${hotel} bukan ${hotel.listkamar}. 
Jika didalam (<..form..>) sudah dispesifikan pada satu objek maka tidak ada th:object lain 
yang dapat dispesifikkan. Ini mengartikan bahwa HTML form tidak dapat iteratif.
Referensi :
- [Baeldug - thymeleaf-in-spring-mvc](https://www.baeldung.com/thymeleaf-in-spring-mvc) 

#### 3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
$ digunakan saat ingin merujuk pada objek yang didapat dari model.addAttribute pada Controller. 
Sedangkan * akan merujuk pada data yang berada pada object yang sudah didefinisikan sebelumnya pada th:object.

#### 4. Bagaimana kamu menyelesaikan latihan nomor 3?  
- Pertama saya mencari terlebih dahulu cara membuat navbar yang tulisannya berada pada pojok kanan. Kemudian saya mendapatkannya pada bootstrap.
- Kedua saya mencari ide bagaimana fragment dapat diisi sebuah parameter saat dipanggil pada html tiap halaman. Saya menggunakan referensi pada https://anshulgnit.blogspot.com/2018/05/difference-between-thymeleaf-attribute-replace-insert-and-include.html
- Ketiga saya mengubah fragment.html saya pada fragment tag navbar menjadi dapat menerima parameter sehingga dapat mengganti sesuai halaman tersebut.
- Kemudian saya mengisi parameter yang sesuai halaman pada tiap title html tersebut di masing - masing html.

---

## Tutorial 5
---
##### 1. Apa itu Postman? Apa kegunaannya?
Postman adalah sebuah aplikasi yang berfungsi sebagai REST Client untuk uji coba REST API. Postman biasa digunakan oleh developer pembuat API sebagai tools untuk menguji API yang telah mereka buat. Pengguna juga diperbolehkan untuk membuat dan menyimpan HTTP request yang dapat dijalankan dan dibaca hasilnya nantinya.
<br> 
Postman merupakan tool untuk melakukan proses development API, untuk saat ini sudah banyak fitur-fitur yang sangat membantu dalam proses development API, diantaranya Collection, Environment, response, MockServer, Script Test, Automated Test (Runner)
<br>
Referensi : 
- [Medium : Postman](https://medium.com/@novancimol12/postman-4f181d625fe1) 

##### 2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
@JsonIgnoreProperties digunakan dalam class level untuk menandai property atau list dari properties untuk diabaikan. Dengan begitu jika suatu saat ada field baru yang dimasukkan di JSON yang merepresentasikan Model kita, maka Jackson tidak akan throw UnrecognizedPropertyException saat parsing JSON di Java.
<br>
@JsonProperty diartikan sebagai logical property yang digunakan di serialization dan deserialization di JSON. saat kita melakukan set JSON data pada Java Object, akan disebut JSON deseralization dan saat kita melakukan get JSON data dari Java Object, disebut JSON serialization. @JsonProperty dapat mengubah visibility dari logical property menggunakan access element saat serialization dan deseralization.
<br>
Referensi :
- [TutorialsPoint : jackson annotation](https://www.tutorialspoint.com/jackson_annotations/jackson_annotations_jsonignoreproperties.htm)
- [javacodegeeks : jsonignoreproperties](https://www.javacodegeeks.com/2018/01/ignore-unknown-properties-parsing-json-java-jackson-jsonignoreproperties-annotation-example.html )
- [concretepage : jacksonjsonproperty](https://www.concretepage.com/jackson-api/jackson-jsonproperty-and-jsonalias-example )

##### 3. Apa kegunaan atribut WebClient?
WebClient class menyediakan method untuk mengirim dan menerima data dari local, intranet, atau internet resource dan diidentifikasi menggunakan URI. WebClient class digunakan webrequest class untuk menyediakan akses ke resource. Instance Webclient dapat mengakses data dari turunan WebRequest apa pun yang terdaftar dengan metode WebRequest.RegisterPrefix. 
<br>
Referensi :
- [Webclient](https://docs.microsoft.com/en-us/dotnet/api/system.net.webclient?view=net-5.0#) 

##### 4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity merepresentasikan keseluruhan HTTP response yaitu status code, headers, dan body. Sebagai hasilnya, kita dapat menggunakannya untuk mengkonfigurasi secara lengkap HTTP response.
<br>
BindingResult adalah objek Spring yang menyimpan hasil validasi dan binding serta berisi error yang mungkin telah terjadi. BindingResult harus muncul tepat setelah objek model yang divalidasi atau Spring akan gagal untuk memvalidasi objek dan mengeluarkan Exception. Dengan kata lain Binding result digunakan sebagai argumen untuk metode validasi dari Validator di dalam Controller. 
<br>
Referensi :
- [baeldung: spring-response-entity](https://www.baeldung.com/spring-response-entity)
- [stackoverflow : bindingresult](https://stackoverflow.com/questions/10413886/what-is-the-use-of-bindingresult-interface-in-spring-mvc/10427459 )
- [codetutr](https://web.archive.org/web/20161120115428/http://codetutr.com/2013/05/28/spring-mvc-form-validation/) 

---

 Tutorial 6 
---
#####1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
Otentikasi adalah verifikasi apakah seseorang itu adalah orang yang berhak. Contoh penerapan otentikasi pada tutorial ini adalah pada saat melakukan login.
<br>
Sedangkan Otorisasi adalah pencarian apakah orang yang sudah diidentifikasi (diotentikasi), diijinkan untuk memanipulasi sumber daya tertentu.Contoh otentikasi pada tutorial ini adalah menerapkan 
<br>.antMatchers("/hotel/**").hasAuthority("RECEPTIONIST")<br>
Yaitu yang dapat mengakses url yang diawali dengan /hotel/ hanya dapat diakses oleh RECEPTIONIST.

Referensi : 
- [yiiframework](https://www.yiiframework.com/doc/guide/1.1/id/topics.auth) 

#####2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
BCryptPasswordEncoder adalah class yang mengimplementasi PasswordEncoder dan menyediakan password hashing. Tidak mungkin untuk melakukan register password dengan plaintext, maka dari itu hashing menjadi kewajiban dalam menyimpan password. Sehingga cara kerja BCryptPasswordEncoder adalah dengan menyimpan password dengan cara dilakukan hashing terlebih dahulu.

Referensi : 
- [PasswordHashing](https://terasolunaorg.github.io/guideline/1.0.x/en/Security/PasswordHashing.html) 

#####3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
UUID adalah kumpulan 32 karakter (String) yang dibuat secara acak (random) dengan teknik khusus yang dijamin unik untuk setiap data. Kegunaan UUID adalah sebagai primary key dari model tersebut. Walaupun UUID begitu lambat, UUID lebih mudah digunakan di sistem terdistribusi, saat semua endpoint bisa membuat data baru, sangat susah untuk mempunyai data yang tersinkronisasi dengan baik. Pada tutorial kali ini kita menggunakan UUID pada user sebagai primary keynya.

Referensi :  [UUID](https://id-laravel.com/post/menggunakan-uuid-di-php-laravel/) 

#####4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?  
Hal ini dikarenakan fungsi dari UserDetailsServiceImpl.java berbeda dengan UserRoleServiceImpl.java. UserDetailsServiceImpl.java melakukan implements interface UserDetailsService dimana telah diberikan oleh springboot untuk digunakan dalam mendapatkan user-related data. UserDetailsServiceImpl.java juga melakukan override method loadUserByUsername() yang berfungsi untuk mengkostumisasi proses dalam pencarian user. 

Referensi : 
- [Baeldung - Spring Security](https://www.baeldung.com/spring-security-authentication-with-a-database) 
