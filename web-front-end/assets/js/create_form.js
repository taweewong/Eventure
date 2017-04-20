var textarea = document.querySelector('textarea');
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

var count = 2;

var html = '';
html += '<div class="question">\n'
html += '<textarea class="input-question" rows="1" name="answer1">Question' + count + '</textarea>\n'
html += '<hr align="left">\n'
html += '</div>\n'

$("#add-btn").click(function() {
	$("form").append(html)
	count += 1;
	html = '';
	html += '<div class="question">\n'
	html += '<textarea class="input-question" rows="1" name="answer1">Question' + count + '</textarea>\n'
	html += '<hr align="left">\n'
	html += '</div>\n'
});