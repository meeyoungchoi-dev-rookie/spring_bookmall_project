# spring_bookmall_project
spring oracle 연동 도서쇼핑몰 프로젝트


# 11월 7일 프로젝트 설정 
- 오라클 라이브러리 추가
- jpa 라이브러리 추가
- mybatis 라이브러리 추가

# 11월 8일 관리자 로그인 
- 관리자 테이블을 데이터베이스와 연동하여 로그인 기능 구현

# 11월 9일 고객 페이지
> 메인카테고리 와 서브카테고리 데이터베이스를 연동하여 화면에 카테고리 데이터 출력
+ 메인카테고리에 속한 데이터출력
+ 흐름: /shopping -> controller -> service -> dao -> mapper
+ [메인카테고리 데이터 출력 과정 상세 코드](https://blog.naver.com/tkgksw/222153608868)
+ 메인카테고리 sequence에 속한 서브카테고리 데이터 출력
+ 흐름: header.jsp -> 메인카테고리 항목 선택시 -> /subacategory/backend/${maincategory.mainCateSeq} -> controller -> service -> dao -> mapper
+ ${maincategory.mainCateSeq}에 메인카테고리 sequence값이 담긴다
+ [메인카테고리 시퀀스를 갖는 서브카테고리 항목 출력 과정 상세 코드](https://blog.naver.com/tkgksw/222153644678)

- 카테고리와 도서 테이블을 연동하여 카테고리별 도서목록 출력
- 도서 상세조회 버튼 클릭시 도서가 속한 메인카테고리와 서브카테고리 출력
- 도서 상세내용을 상세조회 페이지에 출력

# 11월 10일 고객 페이지 로그인 회원가입
> 고객 회원가입 기능 구현
+ 흐름: 회원가입view -> controller -> service -> dao -> sqlSession.insert 디비에 회원정보 저장

> 고객페이지 로그인 기능 구현
+ 흐름: 로그인view -> controller -> service -> dao -> sqlSession.selectOne 디비에 저장된 정보와 일치하는 값이 있는지 검사
+ 있으면 해당 row 반환 session에 담아 로그인 상태유지
+ [로그인 회원가입 상세 소스코드](https://blog.naver.com/tkgksw/222152191916)


> 고객페이지 로그아웃 기능 구현


# 11월 11일 관리자 로그인 수정
- 로그인된 관리자 아이디를 갖고있는 세션의 이름을 뷰페이지에서 null 값 여부 검증을 통해 관리자 로그인 상태 유지

# 11월 11일 장바구니 담기
- 고객이 로그인 되어져있는 상태일때 주문담기 버튼 보여주기
- 로그인된 아이디로 만든 장바구니 세션이 처음 만들어진 세션일때 장바구니 번호 생성
- 동일한 고객이 상품을 계속 장바구니에 담는경우 만들어놓은 장바구니 번호가 계속 유지
- 데이터베이스 장바구니 테이블에 주문번호와 주문한 도서 pk, 주문 수량, 주문 수량별 가격 , 회원번호를 저장
- 장바구니 번호는 새로운 고객이 최조로 장바구니에 상품을 추가할때 만들어진다

# 11월 12일
- 회원개별 장바구니에 담긴 상품 목록 보여주기
- 장바구니 목록 페이제에서 책 제목 구매수량 구매가격 정보 보여주기
- 계속해서 상품을 장바구니에 추가할수있게 계속 쇼핑하기 기능 추가


# 11월 13일
- 회원이 장바구니에 담긴 개별 상품 수량을 변경하는 기능추가
- 상품 수량변경에 따른 수량별 가격과 총 금액도 변경될수 있도록 기능 추가
- 장바구니목록에서 개별 상품을 삭제하는 기능추가
- 장바구니에 담겨있는 상품 전체를 삭제하는 기능추가
- 장바구니페이지에서 주문하기 버튼을 클릭했을때 장바구니에 담긴 상품목록을 주문페이지에서 보여주기

- 장바구니에 담긴 상품을 결제하려는 고객 정보 입력받기
- 결제번호와 결제완료된 상품정보 보여주기
- 결제완료된 도서수량 감소 로직 작성

# 11월 14일
- 관리자 영역
- 카테고리 관리 기능 추가
- 도서관리기능 추가


# 11월 15일
- 관리자 영역
- 도서 이미지 첨부 추가
- 목차 작성을 위한 에디터 적용

# 11월 16일
- 댓글 작성 기능 추가
- 고객이 구매한 도서에 대하서만 댓글을 작성할수 있다

# 11월 17일
- 댓글 수정 삭제 기능 추가
- 로그인된 사용자가 자신의 댓글만 수정 삭제 가능
- 주문 수량만큼 도서 재고수량 감소 기능 추가

# 11월 18일
- 고객이 결제한 상품을 전체 결제 취소하는 기능 추가
- 고객이 결제한 상품을 반품하는 기능 추가
- 고객이 결제한 상품이 관리자로부터 승인이 떨어져서 배송완료가 되는 기능 추가

# 11월 19일
- view 페이지 디자인 수정

