document.addEventListener('DOMContentLoaded', () => {
    fetchOrders();

    const orderForm = document.getElementById('orderForm');
    orderForm.addEventListener('submit', event => {
        event.preventDefault();
        const formData = new FormData(orderForm);
        const order = Object.fromEntries(formData);
        createOrder(order);
    });
});

function fetchOrders() {
    fetch('http://localhost:8080/api/orders')
        .then(response => response.json())
        .then(data => {
            const ordersTableBody = document.querySelector('#ordersTable tbody');
            ordersTableBody.innerHTML = '';
            data.forEach(order => {
                const row = document.createElement('tr');
                Object.values(order).forEach(value => {
                    const cell = document.createElement('td');
                    cell.textContent = value;
                    row.appendChild(cell);
                });
                ordersTableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error fetching orders:', error));
}

function createOrder(order) {
    fetch('http://localhost:8080/api/orders', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(order),
    })
    .then(response => {
        if (response.ok) {
            fetchOrders();
            document.getElementById('orderForm').reset();
        } else {
            console.error('Error creating order:', response.statusText);
        }
    })
    .catch(error => console.error('Error creating order:', error));
}
