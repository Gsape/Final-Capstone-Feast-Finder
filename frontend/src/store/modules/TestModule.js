// import axios from 'axios'

const state = {
    restaurant: {},
    listOfRestaurants: []
};

const getters = {
    allRestaurants: (state) => state.listOfRestaurants
};

const actions = {
    
};

const mutations = {
    setRestaurants: (state, listOfRestaurants) => (state.listOfRestaurants = listOfRestaurants)
};

export default {
    state,
    getters,
    actions,
    mutations
}