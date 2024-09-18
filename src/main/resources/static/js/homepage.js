function amountfunc(val) {
    var amount = 0;

    if (val == 'frontend')
        amount = 7000
    else if (val == 'backend')
        amount = 9000
    else if (val == 'fullstack')
        amount = 12000
    else if (val == 'dsa')
        amount = 6000

    document.getElementById("amount").value=amount
}
window.onload = function(){ 
	document.getElementById('paybutton').onclick = async function(e)
	{
	    const order = await createOrder();
	    console.log(order)

	    var options = {
	        "key": "rzp_test_c8QC2MHekRyfXa",
	        "amount": order.amount,
	        "currency": order.currency,
	        "name": order.name,
	        "description": "Test Payment Transaction",
	        "order_id": order.paymentId,
	        "callback_url": "http://localhost:8082/paymentCallback",
	        "prefill": {
	            "name": order.name,
	            "email": order.email,
	            "contact": order.phoneNo
	        },
	        "notes": {
	            "address": "Razorpay Corporate Office"
	        },
	        "theme": {
	            "color": "#3399cc"
	        }
	    };

	    var rzp = new Razorpay(options);
	    rzp.open();
	    e.preventDefault();
	}
};

async function createOrder()
{
    console.log("==== Order Creation In progress ====")

    const response = await fetch('http://localhost:8082/createOrder', {
        method : 'POST',
        headers : {
            'content-Type' : 'application/json'
        },
        body : JSON.stringify({
            name : document.getElementById('name').value,
            email : document.getElementById('email').value,
            phoneNo : document.getElementById('phone').value,
            course : document.getElementById('course').value,
            amount : document.getElementById('amount').value,
        })
    });

    const order = await response.json();
    console.log("==== Order Creation Completed ====")
    return order;
}