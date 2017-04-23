$('#pass, #pass-con').on('keyup', function () {
    if ($('#pass').val() === '' && $('#pass-con').val() === '') {
        $('#message').html('');
    } else if ($('#pass').val() === $('#pass-con').val()) {
        $('#message').html('Matched').css('color', '#0099FF');
        $("input[name='submit']").prop("type", "submit");
    } else {
        $('#message').html('not Match').css('color', 'red');
        $("input[name='submit']").prop("type", "button");
    }
});

console.log("eieiza" + $("input[name='submit']").prop("type"));

$("input[name='submit']").on('click', function () {
    if ($("input[name='submit']").prop("type") === 'button') {
        alert("Password doesn't match !");
    }
});
