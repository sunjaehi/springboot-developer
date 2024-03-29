//삭제 기능
const deleteButton=document.getElementById('delete-btn');
//id를 delete-btn으로 설정한 엘리먼트를 찾아 클릭 이벤트가 발생하면 fetch()메서드를 통해 DELETE요청을 보냄

if (deleteButton) {
    deleteButton.addEventListener('click',event => {
        let id=document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
        .then(()=> { //fetch()가 잘 완료되면 실행되는 메서드
            alert('삭제가 완료되었습니다.');
            location.replace('/articles');
        });
    });
}
const modifyButton=document.getElementById('modify-btn');

if (modifyButton) {
    //클릭 이벤트가 감지되면 수정 api 요청
    modifyButton.addEventListener('click', event => {
    let params = new URLSearchParams(location,search);
    let id = params.get('id');

    fetch(`/api/articles/${id}`, {
        method: 'PUT',
        headers : {
            "Content-Type" : "application/json",  //요청 형식 지정
        },
        body : JSON.stringify({ //데이터를 JSON 형식으로 바꿔 보냄
            title:document.getElementById('title').value,
            content: document.getElementById('content').value
        })
    })
    .then(()=> {
        alert('수정이 완료되었습니다.');
        location.replace(`/articles/{id}`);
    });
  });
}