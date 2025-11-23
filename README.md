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
1. Create Coupon

POST /api/coupons

{
  "code": "WELCOME100",
  "description": "Flat 100 off for new users",
  "discountType": "FLAT",
  "discountValue": 100,
  "startDate": "2025-01-01",
  "endDate": "2025-12-31",
  "usageLimitPerUser": 1,
  "eligibility": {
    "allowedUserTiers": ["NEW"]
  }
}

2. Best Coupon

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
