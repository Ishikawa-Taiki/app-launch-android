import { FontAwesome } from '@expo/vector-icons';
import { ComponentProps } from 'react';

export type FontAwesomeIconProps = {
  iconName: ComponentProps<typeof FontAwesome>['name'];
  size: number;
  color?: string;
};

export default function FontAwesomeIcon(props: FontAwesomeIconProps): JSX.Element {
  return <FontAwesome name={props.iconName} size={props.size} color={props.color} />;
}
