# ตัวอย่าง Spring Application
เป็นตัวอย่างการนำ Spring MVC ไปใช้งาน มีตัวอย่างการใช้ @Controller และ @RestController ทำงานได้บนฐานข้อมูลทุกชนิด ผ่าน Hibernate ส่วน front-end ใช้ Bootstrap, jQuery และ Angular.js

# สิ่งที่ต้องมี
- MySQL หรือ ฐานข้อมูลอื่น
- JDK
- Apache Maven หรือ IDE เช่น NetBeans

# Build
- ใช้คำสั่ง mvn package
- หรือ เปิด project จาก IDE แล้วเลือก Build

# Run
- ก่อนรันต้อง execute ไฟล์่ schema.sql ในฐานข้อมูลก่อน
- ใช้คำสั่ง java -jar target/spring-app-1.jar
- ใช้คำสั่ง mvn spring-boot:run หรือ
- Run ผ่าน IDE
