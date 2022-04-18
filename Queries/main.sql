select * from book_categories;
select * from book_borrow;
select * from books;


select book_categories.name, count(*) TotalCount from books
inner join book_borrow on books.id = book_borrow.book_id
inner join book_categories on books.book_category_id = book_categories.id
group by book_categories.name
order by TotalCount desc;

select name from book_categories
where name = (
    select book_categories.name from books
    inner join book_borrow on books.id = book_borrow.book_id
    inner join book_categories on books.book_category_id = book_categories.id
    group by book_categories.name
    order by count(*) desc
    limit 1
    );