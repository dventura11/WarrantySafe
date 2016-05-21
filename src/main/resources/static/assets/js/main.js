//Contact Form

$('#submit').click(function(){

$.post("api/...", $(".contact-form").serialize(),  function(response) {
	//TODO
});
return false;

});