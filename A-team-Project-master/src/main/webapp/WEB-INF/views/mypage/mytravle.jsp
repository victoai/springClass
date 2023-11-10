<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"   isELIgnored="false"
   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
	int i= 0;
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset='utf-8' />
  <!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
  <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <!-- jquery CDN -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- fullcalendar CDN -->
  <link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
  <!-- fullcalendar 언어 CDN -->
  <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<style>
  /* 드래그 박스의 스타일 */
  #external-events {
  	position : absolute;
    width: 100px;
    padding: 0 10px;
    border: 1px solid #ccc;
    background: #eee;
    text-align: left;
  }
  #external-events h4 {
    font-size: 16px;
    margin-top: 0;
    padding-top: 1em;
  }
  #external-events .fc-event {
    margin: 3px 0;
    cursor: move;
  }
 
  #external-events p {
    margin: 1.5em 0;
    font-size: 11px;
    color: #666;
  }
 
  #external-events p input {
    margin: 0;
    vertical-align: middle;
  }
 
  #calendar-wrap {
    margin-left: 100px;
  }
 
  #calendar1 {
    max-width: 1100px;
    margin: 0 auto;
  }
</style>

</head>
<body>
  <div id='wrap'>
    <!-- 드래그 박스 -->
    <div id='external-events'>
      <h4>찜목록</h4>
      <div id='external-events-list'>
      	<c:forEach var="travle" items="${travleList }">
	<c:choose>
		<c:when test="${travle.lod_id !=0 }">
			<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'>
				<div class='fc-event-main'>${travle.title }</div>
			</div>
		</c:when>
		<c:when test="${travle.ac_no != 0}">
			<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'>
				<div class='fc-event-main'>${travle.title}</div>
			</div>
		</c:when>
		<c:when test="${travle.fd_no != 0}">
			<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'>
				<div class='fc-event-main'>${travle.title }</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class='fc-event fc-h-event fc-daygrid-event fc-daygrid-block-event'>
				<div class='fc-event-main'>${travle.title }</div>
			</div>
		</c:otherwise>
	</c:choose>
</c:forEach>
      </div>
    </div>
    <!-- calendar 태그 -->
    <div id='calendar-wrap'>
      <div id='calendar1'></div>
    </div>
    
  </div>
  <script>
  (function(){
    $(function(){
      // 드래그 박스 취득
      var containerEl = $('#external-events-list')[0];
      // 설정하기
      new FullCalendar.Draggable(containerEl, {
        itemSelector: '.fc-event',
        eventData: function(eventEl) {
          return {
            title: eventEl.innerText.trim()
          }
        }
      });
      // calendar element 취득
      var calendarEl = $('#calendar1')[0];
      // full-calendar 생성하기
      var calendar = new FullCalendar.Calendar(calendarEl, {
        // 해더에 표시할 툴바
        headerToolbar: {
          left: 'prev,next today',
          center: 'title',
          right: 'dayGridMonth'
        },
        timeZone: 'local',
        initialDate: '2022-11-30', // 초기 날짜 설정 (설정하지 않으면 오늘 날짜가 보인다.)
        locale: 'ko', // 한국어 설정
        editable: true, // 수정 가능
        droppable: true,  // 드래그 가능
        drop: function(arg) { // 드래그 엔 드롭 성공시
          // 드래그 박스에서 아이템을 삭제한다.
          arg.draggedEl.parentNode.removeChild(arg.draggedEl);
        },
        eventDrop: function(info){
        	$.ajax({
        		type:'post',
        		url:'${path}/travle/modSchedule',
        		dataType:'text',
        		data:JSON.stringify({
        			'date' : info.event.startStr,
        			'title' : info.event.title
        		}),
        		contentType:'application/json; charset=utf-8',
        		success: function(data){
        			
        		},
        		error: function(data){
        			alert("실패");
        		}
        	}); 
         },
        eventReceive: function(info){
        	$.ajax({
        		type:'post',
        		url:'${path}/travle/schedule',
        		dataType:'text',
        		data:JSON.stringify({
        			'date' : info.event.startStr,
        			'title' : info.event.title
        		}),
        		contentType:'application/json; charset=utf-8',
        		success: function(data){
        			
        		},
        		error: function(data){
        			alert("실패");
        		}
        	}); 
         },
         
         events : function(info, successCallback, failureCallback) {
		 			$.ajax({
		 				url: '${path}/travle/setSchedule',
		 				type: 'GET',
		 				dataType : 'json',
		 				success: function(data) {
		 					let events = [];
		 					$(data).each(function() {
		 						events.push({
		 							title : this.title,
		 							start : this.day
		 						});
		 					});
		 					successCallback(events);
		 				}
		 			});
         },
         eventClick : function(info){
        	 console.log(info);
        	if(confirm(info.event.title + ' 일정을 삭제하시겠습니까?')){
        		$.ajax({
	 				url: '${path}/travle/delSchedule',
	 				type: 'POST',
	 				dataType : 'text',
	 				contentType:'application/json; charset=utf-8',
	 				data:JSON.stringify({
	        			'date' : info.event.startStr,
	        			'title' : info.event.title
	        		}),
	 				success: function(data) {
	 					info.event.remove();
	 					location.href="${path }/travle/mytravle";
	 				},
	 				error : function(data){
	 					alert('실패');
	 				}
        	});
        		
        	 }
         }
      });
      // 캘린더 랜더링
      calendar.render();
     
    });
  })();

</script>
</body>
</html>