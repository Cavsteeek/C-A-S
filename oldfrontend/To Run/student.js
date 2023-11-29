jQuery(document).ready(function($) {
	tab = $('.tabs h3 a');

	tab.on('click', function(event) {
		event.preventDefault();
		tab.removeClass('active');
		$(this).addClass('active');

		tab_content = $(this).attr('href');
		$('div[id$="tab-content"]').removeClass('active');
		$(tab_content).addClass('active');
	});
});

document.addEventListener('DOMContentLoaded', function () {
    const btnLogin = document.getElementById('btnLogin');

    btnLogin.addEventListener('click', function () {
        window.location.href = 'studentdash.htm';
    });
});
