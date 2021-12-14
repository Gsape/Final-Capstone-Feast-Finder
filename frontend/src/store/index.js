import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
// import TestModule from './modules/TestModule';

 /* The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */

Vue.use(Vuex);

const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},

    restaurant: {
      businessID: '',
      business: '',
      address: '',
      imgURL: '',
      phone: '',
      rating: 0,
      price: '',
      cuisine: ''
    },

    responseJSON: {},
    // restaurant: {
    //   businessID: 'gR9DTbKCvezQlqvD7_FzPw',
    //   business: 'North India Restaurant',
    //   address: '123 Second St',
    //   imgURL: 'https://s3-media1.fl.yelpcdn.com/bphoto/AHm5LPigScMuUG-bT9jqdw/o.jpg',
    //   phone: '123-123-1234',
    //   rating: 5,
    //   price: '$$',
    //   cuisine: 'Indian'
    // },

    searchResults: {}
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },

    SET_RESTAURANT(state, data) {
      state.restaurant = data;
    },
    SET_LIST(state, data){
      state.searchResults.unshift(data);
    }
  }
})
