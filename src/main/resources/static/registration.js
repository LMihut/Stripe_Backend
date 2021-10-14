// A reference to Stripe.js initialized with your real test publishable API key.
var stripe = Stripe("pk_test_51JZ5pyIRPcj0OQ6B8DVxpOA647iYhm7eEqVx6fUi2zWVq4sLbchUYvtyE4DNP1SZvAZEym7vGv005hGbzxobHjDf00kHWTr7Ed");

const emailInput = document.querySelector('#email');

// The items the customer wants to buy
var purchase = {
    items: [{ id: "xl-tshirt" }]
};
fetch('/create-customer', {
    method: 'post',
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify({
        email: emailInput.value,
    }),
})
    .then(function(result) {
    return result.json();
})
    .then(function (data){
        var form = document.getElementById("registration-form");
        form.addEventListener("submit", function(event) {
            event.preventDefault();
            var customerName = document.getElementById("name");
        });
    })


