import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
    //strict: true,
    state: {
        userID:'',
        userName: '',
        questions: [
            { id: 1 , conntent: "ziad is my Name" },
            { id: 2 , conntent: "osama is my brother" }
        ],

    },
    getters: {
        
    },
    mutations: {
        initialiseStore(state) {
            if (localStorage.getItem('userID') ) {
              state.userID = localStorage.getItem('userID');
              state.userName = localStorage.getItem('userName');
            }
        },
        saveUserData:(state , data) =>{
            localStorage.setItem('userID', data._id);
            localStorage.setItem('userName', data._name);
            state.userID = data._id;
            state.userName = data._name;
        },
        saveQuestions:(state , questions) =>{
            console.log("questions = " + questions);
            state.questions = questions;
        }
    },
    actions: {
        getQuestions: async context =>{
            //try {
                console.log('in store ' + store.state.userID);
                let response = [];
                response = await fetch( "http://localhost:5050/getQuestion/" + store.state.userID , {
                    method: "get", 
                    headers: { "Content-Type": "application/json" },
                }).then((res) => {
                    return res.json();
                }).then((data) => {
                    console.log(data);
                    return data;
                })
                console.log("bbbbbbbbb")
                console.log("questions response = " + response);
                context.commit('saveQuestions',response);
            /*} catch (error) {
                alert('error');
            }*/
        }
    }
});