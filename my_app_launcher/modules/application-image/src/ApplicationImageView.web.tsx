import * as React from 'react';

import { ApplicationImageViewProps } from './ApplicationImage.types';

export default function ApplicationImageView(props: ApplicationImageViewProps) {
  return (
    <div>
      <span>{props.name}</span>
    </div>
  );
}
