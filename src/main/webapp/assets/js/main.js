let swiper = new Swiper('.swiper-container', {
	slidesPerView: 5,
	spaceBetween: 40,
	slidesPerGroup: 1,
	loop: true,
	loopFillGroupWithBlank: true,
	pagination: {
		el: '.swiper-pagination',
		clickable: true,
	},
	navigation: {
		nextEl: '.swiper-button-next',
		prevEl: '.swiper-button-prev',
	},
});

$('#myModal').on('shown.bs.modal', function () {
  $('#myInput').trigger('focus')
});
