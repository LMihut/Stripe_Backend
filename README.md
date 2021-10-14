# Stripe_Backend
Backend-Routes für Stripe (Java Spring)

## ressources/templates/application.properties beinhaltet die Stripe-Keys
* stripe.api.key = sk_
* stripe.api.public.key = pk_
* stripe.webhook.secret = whsec_
* stripe.api.price.id_starter = price_
* stripe.api.customer.id = cus_

## Backendroutes
### Customer Controller: Stripe Customer
 ***erstellen (Name, E-Mail)*** POST
```bash
http://localhost:8080/create-customer
```
```bash
{
    "name": "",
    "email": ""
}
```

 ***auflisten (anhand von id)*** GET
```bash
http://localhost:8080/get-customerByID/{id}
```

 ***auflisten (alle Customer)*** GET
```bash
http://localhost:8080/getAll-customer
```


***updaten (anhand von id)*** PATCH
```bash
http://localhost:8080/update-customerByID/{id}
```
```bash
 {
        "name": "",
        "email": "",
        "payment_method": ""
 }
 ```
***löschen (anhand von id)*** DELETE
```bash
http://localhost:8080/update-customerByID/{id}
```

### Product Controller: Stripe Product
 ***erstellen (Name, Type)*** POST
```bash
http://localhost:8080/create-product
```
```bash
{
    "name": "",
    "type": ""
}
```

 ***auflisten (anhand von id)*** GET
```bash
http://localhost:8080/get-productByID/{id}
```

 ***auflisten (alle Produkte)*** GET
```bash
http://localhost:8080/getAll-products
```

***löschen (anhand von id)*** DELETE
```bash
http://localhost:8080/delete-product/{id}
```

### Subscription controller: Stripe Subscription
 ***erstellen*** POST
```bash
http://localhost:8080/create-subscription
```

 ***auflisten (anhand von id)*** GET
```bash
http://localhost:8080/get-subscriptionByID/{id}
```

 ***auflisten (alle Abonnements)*** GET
```bash
http://localhost:8080/getAll-subscriptions
```

***löschen (anhand von id)*** DELETE
```bash
http://localhost:8080/delete-subscription/{id}
```

### Price Controller: Stripe Price
 ***erstellen (id (product id), amount, interval, currency)*** POST
```bash
http://localhost:8080/create-price/{id}
```
```bash
{
    "currency": "",
    "interval": "",
    "amount": ,
    "id": ""
}
```

 ***auflisten (anhand von id)*** GET
```bash
http://localhost:8080/get-productByID/{id}
```

 ***auflisten (alle Produkte)*** GET
```bash
http://localhost:8080/getAll-products
```

***löschen (anhand von id)*** DELETE
```bash
http://localhost:8080/delete-product/{id}
```

### Subscription controller: Stripe Subscription
 ***erstellen*** POST
```bash
http://localhost:8080/create-subscription
```


 ***auflisten (alle Preisen)*** GET
```bash
http://localhost:8080/getAll-prices
```

***löschen (anhand von plan/price id)*** DELETE
```bash
http://localhost:8080/delete-price/{id}
```

###  Payment Controller: Stripe Payment Intent
 ***erstellen (customer (customer id), amount, currency)*** POST
```bash
http://localhost:8080/create-payment-intent
```
```bash
{
  "amount": "",
  "currency": "",
  "customer": ""
}
```

### WebhookController: Stripe Webhook Controller
 ***erstellen*** POST
```bash
http://localhost:8080/stripe/events
```
