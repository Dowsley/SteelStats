import Vue from 'vue';
import Vuetify from 'vuetify/lib';

Vue.use(Vuetify);

/* 
-- Default theme --
primary:   '#1976D2',
secondary: '#424242',
accent:    '#82B1FF',
error:     '#FF5252',
info:      '#2196F3',
success:   '#4CAF50',
warning:   '#FFC107', 
*/

// Change themes here
export default new Vuetify({
  theme: {
    themes: {
      light: {
        // Specific
        background: '#ecedf0',
        containerSquare: '#fbfbfb',
        // General
        primary: '#dcdada',
        secondary: '#3a3c53',
        accent: '#ffb900',
        info: '#222335',
      }
    }
  }
});
