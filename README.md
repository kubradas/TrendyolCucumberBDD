# 🛒 Trendyol Test Automation Framework (EN)

Build with **Maven + Selenium + Cucumber + TestNG**
License: MIT

---

## Project Summary

This is an automation testing framework created to verify basic user flows on the **trendyol.com** website.
It follows the **Page Object Model (POM)** structure and supports Chrome and Firefox browsers.
Reporting is handled via **Extent Reports**.

---

## Test Scenarios (Summary)

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
LinkedIn Profile

---

## License

This project is licensed under the **MIT License**. See the LICENSE file for details.

---

# 🛒 Trendyol Test Otomasyon Framework (Türkçe)

Maven + Selenium + Cucumber + TestNG ile geliştirilmiştir.
Lisans: MIT

---

## Proje Özeti

Bu proje, **trendyol.com** üzerinde temel kullanıcı akışlarını test etmek için oluşturulmuş bir otomasyon framework’üdür.
**Page Object Model (POM)** yapısını takip eder ve Chrome ile Firefox tarayıcılarını destekler.
Raporlama **Extent Reports** ile yapılmaktadır.

---

## Test Senaryoları (Özet)

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
LinkedIn Profilim

---

## Lisans

Bu proje **MIT Lisansı** ile lisanslanmıştır. Detaylar için LICENSE dosyasına bakınız.
