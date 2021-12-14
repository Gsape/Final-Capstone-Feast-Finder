import axios from 'axios'

const state = {
    restaurant: {},
    listOfRestaurants: []
};

const getters = {
    allRestaurants: (state) => state.listOfRestaurants
};

const actions = {
    async fetchRestaurants({ commit }) {
        const response = await axios.get('https://api.yelp.com/v3/businesses/search?term=delis&location=15206')
        console.log(response.data)
    };
    commit("setRestaurants", response.data);
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