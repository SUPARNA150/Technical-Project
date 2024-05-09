const complaintForm = document.getElementById('complaintForm');
    const responseMessage = document.getElementById('responseMessage');

    complaintForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData(complaintForm);

        fetch('submit_complaint.php', {
            method: 'POST',
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                responseMessage.innerHTML = data.message;
                responseMessage.classList.remove('error');
                responseMessage.classList.add('success');
            } else {
                responseMessage.innerHTML = data.message;
                responseMessage.classList.remove('success');
                responseMessage.classList.add('error');
            }
            responseMessage.classList.remove('hidden');
        })
        .catch(error => {
            console.error('Error:', error);
            responseMessage.innerHTML = 'An error occurred. Please try again later.';
            responseMessage.classList.remove('success');
            responseMessage.classList.add('error');
            responseMessage.classList.remove('hidden');
        });
    });