import { StyleSheet } from 'react-native';

// https://reactnative.dev/docs/colors

const CommonSpec = {
  Color: {
    main: 'orange',
    mainChanged: 'darkorange',
    sub: 'skyblue',
    subChanged: 'deepskyblue',
  },
};

export const ViewSpec = {
  TextDefinition: {
    headerTitleDefault: 'My App Launcher',
    shoppingTab: 'お買い物',
    applicationListTab: 'アプリ一覧',
    searchBoxPlaceholder: 'アプリ名で検索',
  },
  FontSize: {
    tabNavigatorText: 24,
    listItem: 18,
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
    detailHeaderTextColor: 'white',
  },
  ImageSize: {
    listIcon: 48,
  },
  Color: {
    appTopNavigatorBackground: CommonSpec.Color.main,
    tabNavigatorBackground: CommonSpec.Color.main,
    tabNavigatorPressBackground: CommonSpec.Color.mainChanged,
    navigateIcon: 'white',
    listBackground: 'white',
    disableListBackground: '#CCCCCC',
    optionButtonBackground: CommonSpec.Color.sub,
    headlineBackground: '#555555',
    directoryIcon: CommonSpec.Color.main,
    todo: 'magenta',
  },
  Margin: {
    listItem: 8,
    imageText: 12,
  },
  BorderStyle: {
    listBorderColor: '#E1E6E6',
    listBorderWidth: StyleSheet.hairlineWidth,
  },
  Operation: {
    delayLongPress: 300,
  },
};
