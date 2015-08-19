# ตัวอย่าง Spring Application
เป็นตัวอย่างการนำ Spring MVC ไปใช้งาน มีตัวอย่างการใช้ @Controller และ 
@RestController ทำงานได้บนฐานข้อมูลทุกชนิด ผ่าน Hibernate 
และใช้ FreeMarker เป็น Template Engine
ส่วน front-end ใช้ Bootstrap, jQuery และ Angular.js
นอกจากนี้ยังรองรับการทำงานหลายภาษา Hello 您好 こんにちは 안녕하세요
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
- ถ้า deploy บน app server ให้ไปที่ URL ที่กำหนดเช่น http://localhost:8080/spring-app
- ใช้ Email: user@codestar.work และ Password: password ในการใช้งาน

# หลักการทำงาน
- pom.xml ระบบนี้ใช้ Maven ในการ build ดังนั้นต้องมี file นี้ก่อน 
- schema.sql ใช้สร้างฐานข้อมูล
- src/main/java/web/Application.java ถ้ารันผ่าน Spring Boot หรือ .jar โปรแกรมจะเริ่มที่นี่
- src/main/java/web/Demo.java ตัวอย่างการใช้ @RestController
- src/main/java/web/Database.java ตัวอย่างการใช้ JDBC
- src/main/java/web/Hibernate.java ตัวอย่างการใช้ Hibernate 
- src/main/java/web/Variable.java ตัวอย่างการรับ parameter แบบธรรมดาและ @PathVariable
- src/main/java/web/Web.java เป็น controller หลักของระบบ
