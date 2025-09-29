# 🛒 Trendyol Test Automation Framework (EN)

[![Build with Maven](https://img.shields.io/badge/build-Maven-5C2D91?logo=apachemaven)](https://maven.apache.org/)
[![Test Framework](https://img.shields.io/badge/Cucumber-7.28.2-brightgreen?logo=cucumber)](https://cucumber.io/)
[![Selenium](https://img.shields.io/badge/Selenium-4.35.0-43B02A?logo=selenium)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.28.2-orange?logo=testng)](https://testng.org/)
[![ExtentReports](https://img.shields.io/badge/ExtentReports-5.1.2-yellow?logo=java)](http://extentreports.com/)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Kübra%20Daşdoğan-0077B5?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kubradas/)

---

## Project Summary

This is an automation testing framework created to verify basic user flows on the **trendyol.com** website.
It follows the **Page Object Model (POM)** structure and supports Chrome and Firefox browsers.
Reporting is handled via **Extent Reports**.

---

## Test Scenarios

* **Sort Products**: Search for a keyword and validate multiple sort types (recommended, price low-to-high, price high-to-low, best sellers, most favorites, newest, most reviewed).
* **Search & Add Product**: Search for a category, select the first product, add it to the cart, and validate cart consistency.
* **Multiple Product Checkout**: Add the same product multiple times, proceed to checkout, and verify login & guest checkout options.

---

## How to Run

1. Clone the project:

   ```bash
   git clone https://github.com/kubradas/TrendyolTestAutomation.git
   cd TrendyolTestAutomation
   ```

2. Configure the browser in `global.properties`:

   ```properties
   url=https://www.trendyol.com/
   browser=chrome
   headless=false
   ```

3. Run the tests via Maven:

   ```bash
   mvn clean test
   ```

---

## Reporting

After test execution, Extent Reports are generated:

* **HTML Report** → `test-output/ExtentReports/SparkReport/Spark.html`
* **Screenshots** → `test-output/SparkReport/Screenshots`

Configured in `extent.properties`:

```properties
extent.reporter.spark.start=true
extent.reporter.spark.out=test-output/SparkReport/Spark.html
screenshot.dir=test-output/SparkReport/Screenshots
```

---

## Developer

**Kübra Daşdoğan**  
Software QA Engineer  
[View LinkedIn Profile](https://www.linkedin.com/in/kubradas/)

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.


---


# 🛒 Trendyol Test Otomasyon Framework (Türkçe)

[![Build with Maven](https://img.shields.io/badge/build-Maven-5C2D91?logo=apachemaven)](https://maven.apache.org/)
[![Test Framework](https://img.shields.io/badge/Cucumber-7.28.2-brightgreen?logo=cucumber)](https://cucumber.io/)
[![Selenium](https://img.shields.io/badge/Selenium-4.35.0-43B02A?logo=selenium)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.28.2-orange?logo=testng)](https://testng.org/)
[![ExtentReports](https://img.shields.io/badge/ExtentReports-5.1.2-yellow?logo=java)](http://extentreports.com/)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Kübra%20Daşdoğan-0077B5?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/kubradas/)

---

## Proje Özeti

Bu proje, **trendyol.com** üzerinde temel kullanıcı akışlarını test etmek için oluşturulmuş bir otomasyon framework’üdür.
**Page Object Model (POM)** yapısını takip eder ve Chrome ile Firefox tarayıcılarını destekler.
Raporlama **Extent Reports** ile yapılmaktadır.

---

## Test Senaryoları

* **Ürün Sıralama**: Belirli bir kelime ile arama yapılıp ürünlerin farklı sıralama tiplerine göre (önerilen, düşükten yükseğe, yüksekten düşüğe, en çok satan, en favoriler, en yeniler, en çok değerlendirilen) sıralandığı doğrulanır.
* **Ürün Arama & Sepete Ekleme**: Kategori araması yapılır, ilk ürün seçilir, sepete eklenir ve sepetteki bilgiler doğrulanır.
* **Çoklu Sepet & Ödeme**: Aynı ürün birden fazla kez sepete eklenir, ödeme sayfasına gidilir, giriş yap / üye olmadan devam et seçenekleri kontrol edilir.

---

## Nasıl Çalıştırılır?

1. Projeyi klonlayın:

   ```bash
   git clone https://github.com/kubradas/TrendyolTestAutomation.git
   cd TrendyolTestAutomation
   ```

2. `global.properties` dosyasında tarayıcıyı seçin:

   ```properties
   url=https://www.trendyol.com/
   browser=chrome
   headless=false
   ```

3. Maven ile testleri çalıştırın:

   ```bash
   mvn clean test
   ```

---

## Raporlama

Test çalıştırıldıktan sonra **Extent Reports** raporları otomatik olarak oluşur:

* **HTML Raporu** → `test-output/ExtentReports/SparkReport/Spark.html`
* **Ekran Görüntüleri** → `test-output/SparkReport/Screenshots`

`extent.properties` ayarları:

```properties
extent.reporter.spark.start=true
extent.reporter.spark.out=test-output/SparkReport/Spark.html
screenshot.dir=test-output/SparkReport/Screenshots
```

---

## Geliştirici

**Kübra Daşdoğan**  
Yazılım Test Mühendisi  
[LinkedIn Profilim](https://www.linkedin.com/in/kubradas/)

---

## Lisans  

Bu proje MIT lisansı ile lisanslanmıştır. Detaylar için [LICENSE](LICENSE) dosyasını inceleyin.

---
