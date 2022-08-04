import Vue from 'vue'
import Home from '../views/Home.vue'
import MyBooks from '@/views/MyBooks';
import NewBook from '@/views/NewBook';
import BookDetail from '@/views/BookDetail';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

const routes = [
{
  path: '/',
  name: 'Home',
  component: Home
},
{
  path: '/myBooks',
  name: 'my-books',
  component: MyBooks
},
{
  path: '/addBook',
  name: 'add-book',
  component: NewBook
},
{
  path: '/book/:isbn',
  name: 'book-detail',
  component: BookDetail
}
];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
