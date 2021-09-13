import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
    //strict: true,
    state: {
        userID:'',
        questions: [
            { id: 1 , conntent: "ziad is my Name" },
            { id: 2 , conntent: "osama is my brother" }
        ],

    },
    getters: {
        
    },
    mutations: {
        
    },
    actions: {
        
    }
});