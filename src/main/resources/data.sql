-- 일반 User 계정 -> 비밀번호 : password123
INSERT INTO users (login_id, password, phone_number, email, role, name)
VALUES ('user1', '$2a$10$Dow1I0umSBnKIXm2OYQJMuPj7/yIWrEh6uTmAYp.B7qUoXjjSWCVG', '010-1111-1111', 'user1@test.com', 'USER', '홍길동');
VALUES ('user2', '$2a$10$Dow1I0umSBnKIXm2OYQJMuPj7/yIWrEh6uTmAYp.B7qUoXjjSWCVG', '010-1111-1111', 'user1@test.com', 'USER', '홍길동');
VALUES ('user3', '$2a$10$Dow1I0umSBnKIXm2OYQJMuPj7/yIWrEh6uTmAYp.B7qUoXjjSWCVG', '010-1111-1111', 'user1@test.com', 'USER', '홍길동');
VALUES ('user4', '$2a$10$Dow1I0umSBnKIXm2OYQJMuPj7/yIWrEh6uTmAYp.B7qUoXjjSWCVG', '010-1111-1111', 'user1@test.com', 'USER', '홍길동');
VALUES ('user5', '$2a$10$Dow1I0umSBnKIXm2OYQJMuPj7/yIWrEh6uTmAYp.B7qUoXjjSWCVG', '010-1111-1111', 'user1@test.com', 'USER', '홍길동');

-- Business 계정 -> 비밀번호 : business123
INSERT INTO users (login_id, password, phone_number, email, role, name)
VALUES ('biz1', '$2a$10$BEsfKQ2biJQ8YMehOJY9EO4TIpPO9oxZdBgYhZ3dUvxZYj.sRoM5y', '010-2222-2222', 'biz1@test.com', 'BUSINESS', '김사장');
VALUES ('biz2', '$2a$10$BEsfKQ2biJQ8YMehOJY9EO4TIpPO9oxZdBgYhZ3dUvxZYj.sRoM5y', '010-2222-2222', 'biz2@test.com', 'BUSINESS', '김사장');
VALUES ('biz3', '$2a$10$BEsfKQ2biJQ8YMehOJY9EO4TIpPO9oxZdBgYhZ3dUvxZYj.sRoM5y', '010-2222-2222', 'biz3@test.com', 'BUSINESS', '김사장');

-- Business 정보 (biz1이 가진 사업체)
INSERT INTO business (user_id, company_address, company_name, business_number)
VALUES (6, '서울시 강남구', '테스트컴퍼니', '123-45-67890');
VALUES (7, '서울시 강남구', '테스트컴퍼니', '123-45-67890');
VALUES (8, '서울시 강남구', '테스트컴퍼니', '123-45-67890');
