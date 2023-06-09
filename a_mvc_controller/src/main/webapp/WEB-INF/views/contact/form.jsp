<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>


<div class="container">
	<div>
		<button class="addForm">폼 추가</button>
		<button class="delForm">폼 삭제</button>
	</div>
	<form method="post" class="contactForm">
		<div class="contactDiv">
			이름 : <input type="text" name="contactList[0].name" class="name"> <br>
			전화번호 : <input type="text" name="contactList[0].phoneNumber" class="phoneNumber"> <br>
		</div>
	</form>
	<button class="submitBtn">전송</button>
</div>

<%@ include file="../layout/footer.jsp" %>

<script>
$(function() {
	let numberDiv = 1;
	
	// 폼 추가 이벤트
	$('.addForm').on('click',function(){
		
		if(numberDiv>=5){
			alert('추가 속성 추가 불가');
			return;
		}
		
		let contactDiv = $('.contactDiv').eq(0).clone(); 
		let nameInput = contactDiv.find('.name')
		let phoneInput = contactDiv.find('.phoneNumber')
		
		let nameInputAttrName = nameInput.attr('name').replace('0',numberDiv)
		let phoneInputAttrNamr = phoneInput.attr('name').replace('0',numberDiv)
		
		nameInput.attr('name', nameInputAttrName)
		phoneInput.attr('name', phoneInputAttrNamr)
		$('.contactForm').append(contactDiv);

	    $('.contactDiv').eq(numberDiv).find('.name').val('');
	    $('.contactDiv').eq(numberDiv).find('.phoneNumber').val('');
		
		
		numberDiv++;
	});
	
	// 폼 삭제 이벤트
	$('.delForm').click(function(){
		if(numberDiv<=1){
			alert('마지막폼 삭제 불가');
			return;
		}
		$('.contactDiv').eq(numberDiv-1).remove()
		numberDiv--;
	});
	
	$('.submitBtn').click(function(){
		$('.contactForm').submit();
	})
});
</script>