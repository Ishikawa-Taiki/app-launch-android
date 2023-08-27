import { ApplicationCommon } from '../../../common/components/ApplicationCommon';
import { useAppSelector } from '../../../common/hooks';
import { selectApplicationsByShortName } from '../selector';

export type ApplicationProps = {
  shortName: string;
};

export const Application = (props: ApplicationProps) => {
  const item = useAppSelector((state) => selectApplicationsByShortName(state, props.shortName));
  const packageName = item?.packageName ?? '';
  const shortName = item?.shortName ?? '';
  return <ApplicationCommon packageName={packageName} shortName={shortName} />;
};
