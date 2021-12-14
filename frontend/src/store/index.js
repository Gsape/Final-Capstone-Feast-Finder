import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
import TestModule from './modules/TestModule';

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
    yelpToken: "2MCP7YJJ-etjT0Mj5aB7skyln1iue4QI-4HuaG5GIt935jt_DfEz3fuoDSdERXDuQWre6R3qUcNDGaTP8olxLBzg4Fh-__QCTQ8zsCAT1xFX84_klZ0_Cc_3x4yqYXYx",
    restaurantList: []
  },
  modules: {
    TestModule
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
    SET_RESTAURANTS(state, restaurantList){
      state.restaurantList = restaurantList;
    }
  }
})
