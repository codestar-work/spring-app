# ตัวอย่าง Spring Application
เป็นตัวอย่างการนำ Spring MVC ไปใช้งาน มีตัวอย่างการใช้ @Controller และ 
@RestController ทำงานได้บนฐานข้อมูลทุกชนิด ผ่าน Hibernate 
และใช้ FreeMarker เป็น Template Engine
ส่วน front-end ใช้ Bootstrap, jQuery และ Angular.js
นอกจากนี้ยังรองรับการทำงานหลายภาษา Hello 您好 こんにちは 안녕하세요

![](https://raw.githubusercontent.com/codestar-work/spring-app/master/page.png)

# สิ่งที่ต้องมี
- MySQL หรือ ฐานข้อมูลอื่น
- JDK
- Maven หรือ IDE เช่น NetBeans

# Build
- ใช้คำสั่ง mvn package
- หรือ เปิด project จาก IDE แล้วเลือก Build

# Run
- ก่อนรันต้อง execute ไฟล์ schema.sql ในฐานข้อมูลก่อน
- ใช้คำสั่ง java -jar target/spring-app-1.jar
- หรือ ใช้คำสั่ง mvn spring-boot:run
- หรือ Run ผ่าน IDE

# การใช้งาน
- เปิด browser ไปที่ http://localhost:3000
- ใช้ Email: user@codestar.work และ Password: password ในการใช้งาน

# การทำงานบน Java Application Server
- web นี้จะ run ที่ / เท่านั้น ถ้าต้องการ deploy บน app server ให้ undeploy / ของเดิมก่อน
- อย่าลืมเปลี่ยน my.upload.path ใน application.properties ให้ตรงกับ app server ที่ใช้อยู่ 
ของ Tomcat มีอยู่แล้ว เอาเครื่องหมาย # ออกก็ใช้ได้เลย อย่าลืมไปสร้าง folder ว่างๆ ชื่อ upload
ที่ apache-tomcat/webapps ด้วย

# หลักการทำงาน
- pom.xml ระบบนี้ใช้ Maven ในการ build ดังนั้นต้องมี file นี้ก่อน 
- schema.sql ใช้สร้างฐานข้อมูล
- src/main/java/web/Application.java ถ้ารันผ่าน Spring Boot หรือ .jar โปรแกรมจะเริ่มที่นี่
- src/main/java/web/Demo.java ตัวอย่างการใช้ @RestController
- src/main/java/web/Database.java ตัวอย่างการใช้ JDBC
- src/main/java/web/Hibernate.java ตัวอย่างการใช้ Hibernate 
- src/main/java/web/Variable.java ตัวอย่างการรับ parameter แบบธรรมดาและ @PathVariable
- src/main/java/web/Web.java เป็น controller หลักของระบบ
- src/main/java/entity/User.java เป็น entity class ของ users ในฐานข้อมูล
- src/main/java/entity/Post.java เป็น entity class ของ posts ในฐานข้อมูล

