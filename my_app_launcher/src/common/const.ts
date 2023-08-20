import { StyleSheet } from 'react-native';

const CommonSpec = {
  Color: {
    main: 'tomato',
    sub: 'powderblue',
  },
};

export const ViewSpec = {
  TextDefinition: {
    headerTitleDefault: 'My App Launcher',
    shoppingTab: 'お買い物',
    applicationListTab: 'アプリ一覧',
  },
  FontSize: {
    tabNavigatorText: 24,
    listItem: 24,
  },
  FontStyle: {
    linkColor: '#0000ee',
    displayTextColor: '#888888',
    errorTextColor: '#ff0000',
    optionButtonTextColor: '#222222',
    headlineTextColor: '#EEEEEE',
    headlineMinHeight: 32,
    appTopNavigatorTextColor: 'white',
    tabNavigatorTextColor: 'white',
  },
  ImageSize: {
    listIcon: 48,
  },
  Color: {
    appTopNavigatorBackground: CommonSpec.Color.main,
    tabNavigatorBackground: CommonSpec.Color.main,
    listBackground: '#ffffff',
    disableListBackground: '#CCCCCC',
    optionButtonBackground: CommonSpec.Color.sub,
    headlineBackground: '#555555',
    directoryIcon: CommonSpec.Color.main,
    todo: '#ff00ff',
  },
  Margin: {
    listItem: 8,
    imageText: 12,
  },
  BorderStyle: {
    listBorderColor: '#E1E6E6',
    listBorderWidth: StyleSheet.hairlineWidth,
  },
};
