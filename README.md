# Dağıtık Sistem Mimarisi

Bu proje, Docker ve Docker Compose kullanarak oluşturulmuş bir dağıtık sistem mimari örneğidir.

## Proje Anlatım Videosu
```
https://drive.google.com/drive/folders/1VXfIg7uLPfa0A7elWznnsrQwIqEkh6lw?usp=sharing
```

## Mimari Bileşenler

- **Nginx**: Yük dengeleyici olarak çalışan bir web sunucusu
- **Spring Boot Uygulamaları (2 node)**: RESTful API sunan Java uygulamaları
- **PostgreSQL**: Veritabanı sunucusu
- **Redis**: Önbellek (cache) sunucusu

## Sistemi Çalıştırma

Sistemi başlatmak için aşağıdaki komutu çalıştırın:

```bash
docker-compose up -d
```

Sistemi durdurmak için aşağıdaki komutu çalıştırın:

```bash
docker-compose down
```

## Sistemi Test Etme

Aşağıdaki URL'yi kullanarak sisteme erişebilirsiniz:

```
http://localhost/api/tasks
```

## CRUD Test Senaryoları
Aşağıda sistemin test edilmesi için kullanılabilecek REST API uç noktaları bulunmaktadır:

### Görev Yönetimi Testleri

- GET /api/tasks - Görev Listeleme
- GET /api/tasks/{id} - Tekil Görev Görüntüleme
- GET /api/tasks/{id} - Olmayan Görev Sorgulama (Geçersiz ID ile test edilebilir)
- POST /api/tasks - Yeni Görev Oluşturma
- PUT /api/tasks/{id} - Görev Güncelleme
- DELETE /api/tasks/{id} - Görev Silme

## Failover Testi

Failover özelliğini test etmek için, çalışan app-node1 veya app-node2 container'larından birini durdurun ve sistemin çalışmaya devam ettiğini gözlemleyebilirsiniz:

```bash
docker stop distribution-system-architecture-app-node1-1
```

veya 

```bash
docker stop distribution-system-architecture-app-node2-1
```

Çalışan (ayakta olan) tüm konteynerleri listeleyelim. Durdurduğumuz node'u doğrulayalım.

```bash
docker ps -a
```

## Dizin Yapısı

- `app/`: Spring Boot uygulaması kaynak kodları
- `nginx/`: Nginx yapılandırma dosyaları
- `docker-compose.yml`: Tüm sistem bileşenlerini tanımlayan Docker Compose dosyası
- `Dockerfile`: Spring Boot uygulamasını derlemek ve çalıştırmak için Docker dosyası
