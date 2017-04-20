var textarea = document.querySelector('#q1');
textarea.addEventListener('keydown', autosize);
             
function autosize(){
  	var el = this;
  	setTimeout(function(){
    	el.style.cssText = 'height:auto; padding:0';
    	// for box-sizing other than "content-box" use:
    	// el.style.cssText = '-moz-box-sizing:content-box';
    	el.style.cssText = 'height:' + el.scrollHeight + 'px';
  	},0);
}

// Delete question
$('.question').on("click", "span", function(event) {
	$(this).parent().parent().fadeOut(function() {
		$(this).remove();
	});
	event.stopPropagation();
});

var count = 1;

var html;

$("#add-btn").click(function() {	
	// reset html variable
	count += 1;
	html = '';
	html += '<div class="question">\n'
	html += '<h3>Question ' + count + ' <span><i class="fa fa-trash-o" aria-hidden="true"></i></span></h3>\n';
	html += '<textarea id="q' + count + '" class="input-question" rows="1" name="answer1"></textarea>\n'
	html += '<hr align="left">\n'
	html += '</div>\n'

	// add html
	$("form").append(html);
	
	// Delete question
	$('.question').on("click", "span", function(event) {
		$(this).parent().parent().fadeOut(function() {
			$(this).remove();
		});
		event.stopPropagation();
	});
	
	// add listener
	textarea = document.querySelector('#q' + count);
	textarea.addEventListener('keydown', autosize);


});

// Delete question
$('#q1').on("click", "span", function(event) {
	$(this).parent().parent().fadeOut(function() {
		$(this).remove();
	});
	event.stopPropagation();
});