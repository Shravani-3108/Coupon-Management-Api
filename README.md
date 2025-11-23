# Coupon-Management-Api

# Project Overview
A Spring Boot application demonstrating APIs for creating coupons and determining the best coupon for a user/cart in an e-commerce scenario.

# Tech Stack
*Language:** Java 17  
*Framework:** Spring Boot  
*Build Tool:** Maven  
*API Testing:** Postman  
*In-Memory Storage:** Java Collections (no database used)
# What I Built
*Create Coupon API:** Stores coupons in memory with eligibility rules.  
*Best Coupon API:** Evaluates all coupons, applies eligibility logic, computes discounts, and returns the best coupon for a given user and cart.  
### Setup Steps
```bash
# Clone repository
git clone https://github.com/Shravani-3108/Coupon-Management-Api.git
cd coupon-management

# Build project
mvn clean install

# Run Spring Boot application
mvn spring-boot:run

Sample API Requests
1. To Create Coupon
POST /api/coupons

{
  "code": "HOME50",
  "description": "Flat ₹50 off on home items",
  "discountType": "FLAT",
  "discountValue": 50,
  "maxDiscountAmount": null,
  "startDate": "2025-05-01",
  "endDate": "2025-12-31",
  "usageLimitPerUser": 3,
  "eligibility": {
    "minCartValue": 500,
    "applicableCategories": ["home"],
    "minItemsCount": 1
  }
}
3.To Check duplicate Coupon is accepted or not
{
  "code": "QUICK25",
  "description": "25% off up to ₹100",
  "discountType": "PERCENT",
  "discountValue": 25,
  "maxDiscountAmount": 100,
  "startDate": "2025-03-01",
  "endDate": "2025-08-30",
  "eligibility": {
    "minCartValue": 100,
    "minItemsCount": 1
  }
} 

2. To get Best Coupon
POST /api/coupons/best

{
  "userContext": {
    "userId": "u123",
    "userTier": "NEW",
    "country": "IN",
    "lifetimeSpend": 1200,
    "ordersPlaced": 2
  },
  "cart": {
    "items": [
      { "productId": "p1", "category": "electronics", "unitPrice": 1500, "quantity": 1 },
      { "productId": "p2", "category": "fashion", "unitPrice": 500, "quantity": 2 }
    ]
  }
}

AI Usage Note
AI tools were used to plan the API structure and logic.
Example prompts:
“Create a Spring Boot REST API for coupon management with eligibility rules.”
“Implement best coupon selection logic based on discount, expiry, and code.”

