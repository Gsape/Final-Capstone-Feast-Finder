import axios from 'axios';

export default {

    addForm(user) {
        return axios.post('/profile', user)
    },

    updatePreferences(data) {
        return axios.put('/profile', data)
    },

    getProfile() {
        return axios.get('/profile')
    },

    addFavorite(data) {
        return axios.post('/restaurants/love', data)
    },

    addHated(ID) {
        return axios.post('/restaurants/hate', ID)
    },

    getFavs() {
        return axios.get('/restaurants/love')
    },

    getHated() {
        return axios.get('/restaurants/hate')
    }
    
}
    